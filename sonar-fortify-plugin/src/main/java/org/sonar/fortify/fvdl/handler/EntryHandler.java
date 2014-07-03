/*
 * Fortify Plugin for SonarQube
 * Copyright (C) 2014 Vivien HENRIET and SonarSource
 * dev@sonar.codehaus.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.fortify.fvdl.handler;

import org.sonar.fortify.fvdl.element.SourceLocation;

public class EntryHandler extends AbstractHandler<SourceLocation> {
  private final NodeHandler nodeHandler;

  EntryHandler() {
    super("Entry");
    this.nodeHandler = new NodeHandler();
    setChildren(this.nodeHandler);
  }

  @Override
  protected void end() {
    SourceLocation sourceLocation = this.nodeHandler.getResult();
    if (sourceLocation != null) {
      setResult(sourceLocation);
    }
  }
}