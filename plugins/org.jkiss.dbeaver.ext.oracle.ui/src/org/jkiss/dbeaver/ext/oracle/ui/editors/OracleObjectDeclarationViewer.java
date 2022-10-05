/*
 * DBeaver - Universal Database Manager
 * Copyright (C) 2010-2022 DBeaver Corp and others
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
package org.jkiss.dbeaver.ext.oracle.ui.editors;

import org.eclipse.jface.action.IContributionManager;
import org.jkiss.dbeaver.ext.oracle.model.OracleSchema;
import org.jkiss.dbeaver.ext.oracle.model.OracleTableBase;
import org.jkiss.dbeaver.model.struct.DBSObject;
import org.jkiss.dbeaver.ui.editors.sql.SQLSourceViewer;


/**
 * OracleObjectDeclarationViewer helps to view object declaration, but not change it
 */
public class OracleObjectDeclarationViewer extends SQLSourceViewer {

    public OracleObjectDeclarationViewer() {
    }

    @Override
    protected boolean isReadOnly() {
        return true;
    }

    @Override
    protected void contributeEditorCommands(IContributionManager toolBarManager) {
        super.contributeEditorCommands(toolBarManager);

        DBSObject sourceObject = getSourceObject();

        if (sourceObject instanceof OracleTableBase || sourceObject instanceof OracleSchema) {
            OracleEditorUtils.addDDLControl(toolBarManager, sourceObject, this);
        }
    }
}
