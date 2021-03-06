/*
 * Copyright 2014-2016 See AUTHORS file.
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
 */

package com.derelictech.impulse;

import com.derelictech.impulse.util.InfoLog;
import com.kotcrab.vis.ui.util.TableUtils;
import com.kotcrab.vis.ui.widget.*;

public class TestScrollPaneWindow extends VisWindow {

    public TestScrollPaneWindow () {
        super("textarea / scrollpane");

        TableUtils.setSpacingDefaults(this);
        columnDefaults(0).left();

        addVisWidgets();

        setResizable(true);
        setSize(300, 500);
        setPosition(28, 300);

        addCloseButton();
    }

    private void addVisWidgets () {
        VisTable toptable = new VisTable();
        VisTable bottable = new VisTable();

        ScrollableTextArea textArea = new ScrollableTextArea("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec iaculis odio.\nFun thing: This text area supports scrolling.");

        // ---

        toptable.add(textArea.createCompatibleScrollPane()).grow().row();

        VisSplitPane vsp = new VisSplitPane(toptable, InfoLog.getTable(), true);
        vsp.setMinSplitAmount(0.1f);
        vsp.setMaxSplitAmount(0.9f);

        add(vsp).grow();
    }
}
