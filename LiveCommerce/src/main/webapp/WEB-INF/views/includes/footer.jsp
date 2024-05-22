<footer>
    <div class="pagination">
        <c:if test="${pageDTO.prev}">
            <a href="?pageNum=${pageDTO.startPage - 1}&amp;amount=${cri.amount}">&laquo;</a>
        </c:if>
        
        <c:forEach var="pageNum" begin="${pageDTO.startPage}" end="${pageDTO.endPage}">
            <c:if test="${pageNum eq cri.pageNum}">
                <span class="active">${pageNum}</span>
            </c:if>
            <c:if test="${pageNum ne cri.pageNum}">
                <a href="?pageNum=${pageNum}&amp;amount=${cri.amount}">${pageNum}</a>
            </c:if>
        </c:forEach>
        
        <c:if test="${pageDTO.next}">
            <a href="?pageNum=${pageDTO.endPage + 1}&amp;amount=${cri.amount}">&raquo;</a>
        </c:if>
    </div>
</footer>
</body>
</html>
