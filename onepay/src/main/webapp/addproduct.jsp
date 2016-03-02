<%@page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<jsp:include page="./fragments/headTag.jsp" />
<title>添加个东西</title>

<jsp:include page="./fragments/bodyHeader.jsp" />

<form>
	<div class="form-group">
		<label for="inputProductName">商品名称</label> <input type="text"
			class="form-control" id="inputProductName" placeholder="商品名称">
	</div>

	<div class="form-group">
		<label for="exampleInputFile">图片</label> <input type="file"
			id="exampleInputFile">
		<p class="help-block">上传图片有助于客户更好的了解产品.</p>
	</div>
	<div class="form-group">
		<label for="exampleInputFile">拍卖类型</label>
		<div class="radio">
			<label> <input type="radio" name="optionsRadios"
				id="optionsRadios1" value="option1" checked> 定时秒杀拍
			</label>
		</div>
		<div class="radio">
			<label> <input type="radio" name="optionsRadios"
				id="optionsRadios2" value="option2">3天内拍
			</label>
		</div>
		<div class="radio">
			<label> <input type="radio" name="optionsRadios"
				id="optionsRadios2" value="option2">猜价拍
			</label>
		</div>
	</div>
	<div class="form-group">
		<label for="exampleInputFile">新旧程度</label>
		<div aria-label="Toolbar with button groups" role="toolbar"
			class="btn-toolbar">
			<div aria-label="First group" role="group" class="btn-group">
				<button class="btn btn-default" type="button">1</button>
				<button class="btn btn-default" type="button">2</button>
				<button class="btn btn-default" type="button">3</button>
				<button class="btn btn-default" type="button">4</button>
			</div>
			<div aria-label="Second group" role="group" class="btn-group">
				<button class="btn btn-default" type="button">5</button>
				<button class="btn btn-default" type="button">6</button>
				<button class="btn btn-default" type="button">7</button>
			</div>
			<div aria-label="Third group" role="group" class="btn-group">
				<button class="btn btn-default" type="button">8</button>
				<button class="btn btn-default" type="button">9</button>
				<button class="btn btn-default" type="button">10</button>
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="exampleInputFile">描述</label>
		<textarea class="form-control" rows="3"></textarea>
	</div>
	<div class="form-group">
		<label for="exampleInputFile">标签</label> <span
			class="label label-info">电器</span> <span class="label label-info">全新</span>
		<span class="label label-info">未拆封</span>
		<form class="form-inline">
			<div class="form-group">
				<label class="sr-only" for="exampleInputAmount">Amount (in
					dollars)</label>
				<div class="input-group">
					<div class="input-group-addon">标签</div>
					<input type="text" class="form-control" id="exampleInputAmount"
						placeholder="Amount">
				</div>
			</div>
			<button type="submit" class="btn btn-primary">添加</button>
		</form>
	</div>
	<div class="checkbox">
		<label> <input type="checkbox"> 同意一元网的条款
		</label>
	</div>
	<button type="submit" class="btn btn-default">Submit</button>
</form>

<jsp:include page="./fragments/footer.jsp" />


