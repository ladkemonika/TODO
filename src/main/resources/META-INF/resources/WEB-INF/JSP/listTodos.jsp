
<%@ include file="common/header.jspf"%>

<%@ include file="common/navigation.jspf"%>
<div class="container">

	<h1>Your Todos</h1>

	<table class="table">
		<thead>

			<th>Description</th>
			<th>Target Date</th>
			<th>Is Done?</th>
			<th></th>
			<th></th>
		</thead>
		<tbody>
			<c:forEach items="${todos }" var="todo">
				<tr>

					<td>${todo.description }</td>
					<td>${todo.target }</td>
					<td>${todo.done }</td>
					<td><a href="delete-todo?id=${todo.id }"
						class="btn btn-warning">DELETE</a></td>
					<td><a href="update-todo?id=${todo.id }"
						class="btn btn-success">UPDATE</a></td>
				</tr>
			</c:forEach>
		</tbody>

	</table>
	<a href="add-todo" class="btn btn-success">Add Todo</a>
</div>

<%@ include file="common/footer.jspf"%>
