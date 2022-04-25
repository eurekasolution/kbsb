// index.js

var main = {
    init : function() {
        var _this = this;
        $('#btn-write').on('click', function() {
            _this.save();
        });
    },

    save : function() {
        var data = {
            title: $('#title').val(),
            content: $('#content').val(),
            author: $('#author').val()
        };

        $.ajax({
            type: 'POST',
            dataType: 'json',
            url: '/api/v1/posts',    // localhost:8080/api/v1/posts
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(returnData){
            alert('글이 등록되었습니다.');
            $("#debug").html(returnData);
            location.href='/';
        }).fail(function(error){
            alert(error);
            $("#debug").html(error);
            alert(JSON.stringify(error));
        })
    }
}

main.init();

