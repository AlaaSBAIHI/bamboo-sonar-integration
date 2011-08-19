<!--
 ~ Licensed to Marvelution under one or more contributor license 
 ~ agreements.  See the NOTICE file distributed with this work 
 ~ for additional information regarding copyright ownership.
 ~ Marvelution licenses this file to you under the Apache License,
 ~ Version 2.0 (the "License"); you may not use this file except
 ~ in compliance with the License.
 ~ You may obtain a copy of the License at
 ~
 ~  http://www.apache.org/licenses/LICENSE-2.0
 ~
 ~ Unless required by applicable law or agreed to in writing,
 ~ software distributed under the License is distributed on an
 ~ "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 ~ KIND, either express or implied. See the License for the
 ~ specific language governing permissions and limitations
 ~ under the License.
 -->
<html>
<head>
	<title>[@ww.text name='sonar.gadgets.title' /]</title>
	<meta name="decorator" content="adminpage">
</head>
<body>
	<h1>[@ww.text name='sonar.gadgets.heading' /]</h1>
	<p>[@ww.text name='sonar.gadgets.description' /]</p>
	<div class="paddedClearer" ></div>

	[#macro gadgetSection gadgetKey]
		<h2>${i18nResolver.getText('sonar.gadget.${gadgetKey}.title')}</h2>
		<img class='gadgetScreenshot' src="[@cp.getStaticResourcePrefix /]/download/resources/${pluginKey}/images/gadgets/sonar-${gadgetKey}-screenshot.png">
		<div class='gadgetText'>
		${i18nResolver.getText("sonar.gadget.${gadgetKey}.description")}<br/>
		[@ww.text name='sonar.gadget.url']
            [@ww.param]${baseUrl}/rest/gadgets/1.0/g/${pluginKey}/gadgets/sonar-${gadgetKey}-gadget.xml[/@ww.param]
        [/@ww.text]
		</div>
		[@ui.clear/]
	[/#macro]

	[#list gadgetIds as gadgetId]
		[@gadgetSection gadgetKey='${gadgetId}' /]
	[/#list]
</body>
</html>