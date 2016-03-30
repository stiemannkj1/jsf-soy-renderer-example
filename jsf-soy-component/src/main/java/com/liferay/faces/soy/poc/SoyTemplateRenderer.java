/**
 * Copyright (c) 2000-2016 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
package com.liferay.faces.soy.poc;

import java.io.IOException;
import java.net.URL;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;

import com.google.template.soy.SoyFileSet;
import com.google.template.soy.data.SoyMapData;
import com.google.template.soy.tofu.SoyTofu;


/**
 * @author  Kyle Stiemann
 */
@FacesRenderer(componentFamily = OutputHello.COMPONENT_FAMILY, rendererType = OutputHello.RENDERER_TYPE)
public class SoyTemplateRenderer extends Renderer {

	@Override
	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
		// super.encodeBegin(context, component);
	}

	@Override
	public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
		// super.encodeChildren(context, component);
	}

	@Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {

		OutputHello outputHello = (OutputHello) component;

		final Object value = outputHello.getValue();

		if (value != null) {

			ResponseWriter responseWriter = context.getResponseWriter();
			SoyFileSet.Builder builder = new SoyFileSet.Builder();
			URL url = SoyTemplateRenderer.class.getResource("/jsf/soy/poc/hello.soy");
			System.out.println(url);
			builder.add(url);

			SoyFileSet soyFileSet = builder.build();
			SoyTofu tofu = soyFileSet.compileToTofu();
			SoyTofu.Renderer soyRenderer = tofu.newRenderer("jsf.soy.poc.hello");
			soyRenderer.setData(new SoyMapData("name", value));
			responseWriter.write(soyRenderer.render());
		}
	}
}
