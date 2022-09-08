function fileBtn() {
    document.getElementById('file').click()
}

function upload(file) {
    let img = document.getElementById('img')
    let formData = new FormData()
    let temp = file.files[0]
    if (temp){
        formData.append('file',temp)
        img.src = window.URL.createObjectURL(temp)
        $.ajax({
            url:"/test/file2",
            type:"POST",
            data: formData,
            processData: false, // 告诉jQuery不要去处理发送的数据
            contentType: false, // 告诉jQuery不要去设置Content-Type请求头
            success: function(result){
                alert(result);
            }
        })
    }
}