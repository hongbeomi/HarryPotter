package github.hongbeomi.detail

/**
 * Copyright 2020 Hongbeom Ahn
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 **/

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration

class SpaceItemDecoration(private val space: Int, private val mNumCol: Int) : ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.apply {
            right = space
            bottom = space
            left = space
        }

        val position = parent.getChildLayoutPosition(view)
        if (mNumCol <= 2) {
            if (position == 0) {
                outRect.left = space
                outRect.right = space / 2
            } else {
                if (position % mNumCol != 0) {
                    outRect.left = space / 2
                    outRect.right = space
                } else {
                    outRect.left = space
                    outRect.right = space / 2
                }
            }
        } else {
            if (position == 0) {
                outRect.left = space
                outRect.right = space / 2
            } else {
                when {
                    position % mNumCol == 0 -> {
                        outRect.left = space
                        outRect.right = space / 2
                    }
                    position % mNumCol == mNumCol - 1 -> {
                        outRect.left = space / 2
                        outRect.right = space
                    }
                    else -> {
                        outRect.left = space / 2
                        outRect.right = space / 2
                    }
                }
            }
        }
    }

}