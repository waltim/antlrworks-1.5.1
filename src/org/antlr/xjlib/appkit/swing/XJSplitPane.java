/*

[The "BSD licence"]
Copyright (c) 2008 Jean Bovet
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions
are met:

1. Redistributions of source code must retain the above copyright
notice, this list of conditions and the following disclaimer.
2. Redistributions in binary form must reproduce the above copyright
notice, this list of conditions and the following disclaimer in the
documentation and/or other materials provided with the distribution.
3. The name of the author may not be used to endorse or promote products
derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

*/

package org.antlr.xjlib.appkit.swing;

import javax.swing.*;
import java.awt.*;

/**
 * This class is used to workaround the multiple positioning issues with
 * the divider location. This class uses the workarounds described here:
 * http://www.jguru.com/faq/view.jsp?EID=27191
 * 
 */
public class XJSplitPane extends JSplitPane {

    private boolean isPainted = false;
    private double proportional;

    public XJSplitPane(double proportional) {
        this.proportional = proportional;
    }

    public XJSplitPane() {
        isPainted = true;
    }

    @Override
    public void paint(Graphics graphics) {
        if(!isPainted) {
            super.setDividerLocation(proportional);
            isPainted = true;
            //doLayout();
        }
        super.paint(graphics);
    }

}
