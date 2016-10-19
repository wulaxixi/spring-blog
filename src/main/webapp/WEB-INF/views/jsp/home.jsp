<%@ taglib prefix="blog-tags" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<blog-tags:header />

<script type="text/javascript">
    $("#homeTab").addClass("active");
    
</script>

<div class="container"><!--Body content start-->
    <div class="row">
        <!--Left Column-->
        <div class="col-sm-9 col-xs-12">

            <!--Page Content Start-->
            <blog-tags:blogPostList blogPosts="${blogPosts}" />


            <div class="text-center"> <!--Pagination Start-->
                <ul class="pagination">
                    <!--Previous Page-->
                    <c:choose>
                        <c:when test="${currentPage > 1}">
                            <li><a href="${contextPath}/blog?page=${currentPage-1}">&laquo;</a></li>
                        </c:when>
                        <c:otherwise>
                            <li class="disabled"><a disabled>&laquo;</a></li>
                        </c:otherwise>
                    </c:choose>

                    <!--pages-->
                    <c:forEach begin="1" end="${numPages}" var="page">
                        <c:choose>
                            <c:when test="${page == currentPage}">
                                <li class="active"><a disabled>${page}</a></li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="${contextPath}/blog?page=${page}">${page}</a></li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>

                    <!--Next Page-->  
                    <c:choose>
                        <c:when test="${currentPage < numPages}">
                            <li><a href="${contextPath}/blog?page=${currentPage+1}">&raquo;</a></li>
                        </c:when>
                        <c:otherwise>
                            <li class="disabled"><a disabled>&raquo;</a></li>
                        </c:otherwise>
                    </c:choose>

                </ul>
            </div> <!--Pagination End-->

        </div><!--Body content end-->

        <div class="col-sm-3 col-xs-12"><!--Sidebar start-->
            <blog-tags:blogSidebar />
        </div><!--Sidebar end-->
        <div class="progressDiv">
        	<button onclick="calculate()">begin caluate</button>
        	<br/>
        	progress:has done<span class="onProgressSpan"></span>  /totle 100.
        </div>
        
    </div>
</div>
<script type="text/javascript">
	function calculate(){ 
		debugger;
		var htmlobj=$.ajax({url:"/ProgressBar/plus",async:false});
		$(".onProgressSpan").html(htmlobj.responseText);
		var i = setInterval(function() {
			var result=$.ajax({url:"/ProgressBar/rtnProgress",async:false});
			
			console.log(result.responseText);
			$(".onProgressSpan").html(result.responseText);
            if (result.responseText >= 100)
                clearInterval(i);
        }, 1000);
	}
	
</script>

<blog-tags:footer />
