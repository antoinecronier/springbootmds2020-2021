<#function avg x y>
  <#return "<div>moyenne:" + (x+y)/2 +"</div>">
</#function>

<#assign title = "Page test4">
${title}

${model1}
${model2}

<#if model3??>
	${model3}
</#if>

<#assign colMd = "4">
<div class="row">
	<div class="col-md-${colMd}">
	</div>
</div>


${avg(10, 20)}