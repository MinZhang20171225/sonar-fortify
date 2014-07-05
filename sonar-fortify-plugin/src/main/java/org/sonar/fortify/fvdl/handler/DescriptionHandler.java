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

import org.sonar.fortify.base.handler.StringHandler;

import org.sonar.fortify.base.handler.AbstractSetHandler;
import org.sonar.fortify.fvdl.element.Description;
import org.xml.sax.Attributes;

public class DescriptionHandler extends AbstractSetHandler<Description> {
  private final StringHandler abstractHandler;
  private Description description;

  DescriptionHandler() {
    super("Description");
    this.abstractHandler = new StringHandler("Abstract");
    setChildren(this.abstractHandler);
  }

  @Override
  protected void start(Attributes attributes) {
    this.description = new Description();
    this.description.setClassID(attributes.getValue("classID"));
  }

  @Override
  protected void end() {
    this.description.setAbstract(this.abstractHandler.getResult());
    add(this.description);
  }
}
