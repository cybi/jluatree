/*
 * Copyright 2018 Jens Kötterheinrich
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package de.beckdev;

import com.sun.javafx.scene.control.skin.TreeViewSkin;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class TreeUtil {
    public static void setColorOtherNodes(TreeItem<TextNode> node, TreeItem<TextNode> nodeToSearch, String color, LastClickedItemContainer lastClickedItemContainer) {
        ObservableList<TreeItem<TextNode>> children = node.getChildren();
        for (TreeItem<TextNode> child : children) {
            if (!child.equals(lastClickedItemContainer.lastClickedItem)) {
                if (!child.getChildren().isEmpty()) {
                    setColorOtherNodes(child, nodeToSearch, color, lastClickedItemContainer);
                }
                if (child.getValue().equals(nodeToSearch.getValue())) {
                    setColorParents(child, color);
                }
            }

        }
    }

    public static void resetTree(TreeView<TextNode> tree) {
        tree.getRoot().getValue().setColor("#ffffff");
        setColorChildren(tree.getRoot(), "#ffffff");
        setColorParents(tree.getRoot(), "#ffffff");
    }

    public static Object refresh(TreeView<TextNode> tree) {
        return tree.getProperties().put(TreeViewSkin.RECREATE, Boolean.TRUE);
    }

    public static void setColorParents(TreeItem<TextNode> item, String color) {
        if (item != null) {
            if (item.getParent() != null) {
                item.getParent().getValue().setColor(color);
                setColorParents(item.getParent(), color);
            }
        }
    }

    public static void setColorChildren(TreeItem<TextNode> item, String color) {
        if (item != null) {
            if (item.getChildren() != null) {
                for (TreeItem<TextNode> child : item.getChildren()) {
                    child.getValue().setColor(color);
                    setColorChildren(child, color);
                }
            }
        }
    }
}
