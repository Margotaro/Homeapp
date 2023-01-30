/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.homeapp.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.homeapp.ui.BottomTabDestination
import com.example.homeapp.ui.theme.TypographyMetropolis


@Composable
fun BottomTabRow(
    allScreens: List<   BottomTabDestination>,
    onTabSelected: (BottomTabDestination) -> Unit,
    currentScreen: BottomTabDestination
) {
    Surface(
        Modifier
            .height(TabHeight)
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
    ) {
        Row(
            modifier = Modifier.selectableGroup(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            allScreens.forEach { screen ->
                BottomTab(
                    text = screen.route,
                    icon = ImageVector.vectorResource(id = screen.iconId),
                    selectedTabIcon = ImageVector.vectorResource(id = screen.selectedIconId),
                    onSelected = { onTabSelected(screen) },
                    selected = currentScreen == screen
                )
            }
        }
    }
}

@Composable
private fun BottomTab(
    text: String,
    icon: ImageVector,
    selectedTabIcon: ImageVector,
    onSelected: () -> Unit,
    selected: Boolean
) {
    val color = Color.Unspecified
    val durationMillis = if (selected) TabFadeInAnimationDuration else TabFadeOutAnimationDuration
    val animSpec = remember {
        tween<Color>(
            durationMillis = durationMillis,
            easing = LinearEasing,
            delayMillis = TabFadeInAnimationDelay
        )
    }
    val tabTintColor by animateColorAsState(
        targetValue = if (selected) color else Color.Unspecified,
        animationSpec = animSpec
    )
    Column(
        modifier = Modifier
            .padding(16.dp)
            .animateContentSize()
            .height(TabHeight)
            .selectable(
                selected = selected,
                onClick = onSelected,
                role = Role.Tab,
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(
                    bounded = false,
                    radius = Dp.Unspecified,
                    color = MaterialTheme.colors.onPrimary
                )
            )
            .clearAndSetSemantics { contentDescription = text },
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(imageVector = if(!selected) icon else selectedTabIcon, contentDescription = text, tint = tabTintColor)
        Spacer(Modifier.height(8.dp))
        Text(text, color = tabTintColor, fontSize = 12.sp, style = TypographyMetropolis.subtitle1)
    }
}

private val TabHeight = 90.dp

private const val TabFadeInAnimationDuration = 150
private const val TabFadeInAnimationDelay = 100
private const val TabFadeOutAnimationDuration = 100
