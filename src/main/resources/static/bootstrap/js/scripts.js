/*!
* Start Bootstrap - Personal v1.0.1 (https://startbootstrap.com/template-overviews/personal)
* Copyright 2013-2023 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-personal/blob/master/LICENSE)
*/
// This file is intentionally blank
// Use this file to add JavaScript to your project

        const commentCreateBtn = document.querySelector("#comment-create-btn");
        commentCreateBtn.addEventListener("click", function(){
        // 새 댓글 객체 생성
        const comment = {
        //새 댓글의 닉네임
        nickname: document.querySelector("#new-comment-nickname").value,
        //새 댓글의 본문
        body: document.querySelector("#new-comment-body").value,
        //부모 게시글의 id
        articleId: document.querySelector("#new-comment-article-id").value
    };
        //댓글 객체 출력
        console.log(comment);
        //fetch()-비동기통신을 위한 API
        const url="/api/articles/" + comment.articleId + "/comments";
        fetch(url, {
        method: "POST",
        headers: {
        "Content-Type": "application/json"
    },
        body: JSON.stringify(comment)
    });
        <!--        .then(response => {-->
        <!--           const msg = (response.ok) ? "댓글이 등록됐습니다." : "댓글 등록 실패..!";-->
        <!--           alert(msg);-->

        <!--           window.location.reload();-->
        <!--        });-->
    });
