<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/topbar.jsp"%>
<a href="${pageContext.request.contextPath }/admin/category/add">Thêm mới</a>

<c:forEach items="${cateList}" var="cate" varStatus="STT">
    <tr>
        <td>${STT.index + 1}</td>
        <td>
            <c:url value="/image?fname=${cate.icon}" var="imgUrl"/>
            <img src="${imgUrl}" width="200" height="150"/>
        </td>
        <td>${cate.catename}</td>
        <td>
            <a href="<c:url value='/admin/category/edit?id=${cate.cateid}'/>">Sửa</a> | 
            <a href="<c:url value='/admin/category/delete?id=${cate.cateid}'/>">Xóa</a>
        </td>
    </tr>
</c:forEach>

