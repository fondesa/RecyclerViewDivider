/*
 * Copyright (c) 2019 Fondesa
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fondesa.recyclerviewdivider.manager.inset

import androidx.annotation.Px
import androidx.recyclerview.widget.StaggeredGridLayoutManager

/**
 * Defines a [InsetManager] which doesn't depend on the item's position.
 */
abstract class FixedInsetManager : InsetManager {

    @Px
    final override fun itemInsetBefore(groupCount: Int, groupIndex: Int): Int = itemInsetBefore()

    @Px
    final override fun itemInsetAfter(groupCount: Int, groupIndex: Int): Int = itemInsetAfter()

    /**
     * @see InsetManager.itemInsetBefore
     */
    @Px
    abstract fun itemInsetBefore(): Int

    /**
     * @see InsetManager.itemInsetAfter
     */
    @Px
    abstract fun itemInsetAfter(): Int
}

/**
 * Checks if the given [InsetManager] is a [FixedInsetManager], otherwise throws an exception.
 *
 * @return the [InsetManager] casted to [FixedInsetManager].
 * @throws IllegalArgumentException if [InsetManager] isn't a [FixedInsetManager].
 */
internal fun InsetManager.asFixed(): FixedInsetManager {
    require(this is FixedInsetManager) {
        "Only ${FixedInsetManager::class.java.name} is supported with ${StaggeredGridLayoutManager::class.java.name}"
    }
    return this
}