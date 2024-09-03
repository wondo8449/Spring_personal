/*
*   /faq/read.html
* */

console.log("Reply Module 들어옴");
let replyService = (function(){

    function add(reply, callback, error){
        $.ajax({
            url: "/reply/new",
            type: "post",
            data: JSON.stringify(reply),
            contentType: "application/json; charset=utf-8",
            success: function(result){
               if(callback){
                   callback(result);
               }
            },
            error: function(xhr, status, er){
                if(error){
                    error(xhr, status, er);
                }
            }
        });
    }

    //댓글 목록
    function getList(param, callback, error){
        let page = param.page || 1;
        $.ajax({
            url: "/reply/list/" + param.boardNumber + "/" + page,
            success: function(replies){
                if(callback){
                    callback(replies);
                }
            }
        })
    }

    //댓글 한 개 정보 가져오기
    function read(replyNumber, callback, error){
        $.ajax({
            url: "/reply/" + replyNumber,
            type: "get",
            success: function(reply){
                console.log(reply)
            }
        })
    }

    //댓글 삭제
    function remove(replyNumber, callback, error){
        $.ajax({
            url: "/reply/" + replyNumber,
            type: "delete",
            success: function(){
                if(callback){
                    callback();
                }
            }
        })
    }

    // 댓글 수정
    function modify(reply, callback, error){
        $.ajax({
            url: "/reply/modify",
            type: "post",
            data: JSON.stringify(reply),
            contentType: "application/json; charset=utf-8;",
            success: function(){
                if(callback){
                    callback();
                }
            }
        });
    }

    //댓글 작성 시간(Javascript)
    // function getReplyDateByJavascript(replyDate){
    //     let today = new Date();
    //     let rDate = new Date(replyDate);
    //     let gap = today.getTime() - rDate.getTime();
    //
    //     if(gap < 1000 * 60 * 60 * 24){
    //         let h = rDate.getHours();
    //         let m = rDate.getMinutes();
    //         let s = rDate.getSeconds();
    //
    //         return [(h < 10 ? '0' : '') + h, (m < 10 ? '0' : '') + m, (s < 10 ? '0' : '') + s].join(":");
    //     }else{
    //         let y = rDate.getFullYear();
    //         let m = rDate.getMonth() + 1;
    //         let d = rDate.getDate();
    //
    //         return [y, (m < 10 ? '0' : '') + m, (d < 10 ? '0' : '') + d].join("-")
    //     }
    // }

    //댓글 수정 시간(JAVA)
    // function getReplyDateByController(replyDate){
    //     let result;
    //     $.ajax({
    //         url: "/time",
    //         type: "get",
    //         data: {replyDate: replyDate},
    //         async: false, //아래의 콜백함수의 연산이 모두 끝나고 나서 다음 작업이 진행된다.
    //         success: function(time){
    //             result = time;
    //         }
    //     });
    //     return result;
    // }

    function timeForToday(value) {
        const today = new Date();
        const timeValue = new Date(value);

        const betweenTime = Math.floor((today.getTime() - timeValue.getTime()) / 1000 / 60);
        if(betweenTime < 1) return '방금 전';
        if(betweenTime < 60) {
            return `${betweenTime}분전`
        }

        const betweenTimeHour = Math.floor(betweenTime / 60);
        if(betweenTimeHour < 24) {
            return `${betweenTimeHour}시간전`
        }

        const betweenTimeDay = Math.floor(betweenTime / 60 / 24);
        if (betweenTimeDay < 365) {
            return `${betweenTimeDay}일전`;
        }

        return `${Math.floor(betweenTimeDay / 365)}년전`;
    }

    return {add: add, getList: getList, read: read, remove: remove, modify: modify, timeForToday: timeForToday}
})();