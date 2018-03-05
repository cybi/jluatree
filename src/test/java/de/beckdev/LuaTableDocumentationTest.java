/*
 * Copyright 2018 Beckmann & Partner CONSULT
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

package de.beckdev;

import javafx.scene.control.TreeItem;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LuaTableDocumentationTest {

    @Test
    public void getTreeItem() throws URISyntaxException, IOException {
        String filename = "/iupluaBaumObjektorientiertAlleAbfragenSchnittstelleLuaTabellen.lua";
        LuaTableDocumentation documentation = new LuaTableDocumentation(Paths.get(getClass().getResource(filename).toURI()));
        TreeItem<TextNode> treeItem = documentation.getTreeItem();

        assertNotNull(treeItem);
        TextNode node = treeItem.getValue();
        assertEquals("Datenbankzusammenhänge objektorientiert", node.getText());
        assertEquals("#ffffff", node.getColor());
    }
}
