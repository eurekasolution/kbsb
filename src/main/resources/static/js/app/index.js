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
            data: JSON.stringify(data),

            success: function(returnData) {
                alert('글이 등록되었습니다.');
                $("#debug").html(returnData);
                location.href='/';
            },
            error:function(error, exception) {
                var msg = '';
                if(error.status === 0)
                    msg = 'Not Connected';
                else if(error.status == 404)
                    msg = 'Not Found';
                else if(error.status == 500)
                    msg = 'Server Error';
                else
                    msg = 'Unknown Error';

                alert(msg);
            }
        });
    }
}

main.init();

