
$(function(){
    // 首屏轮播图下方横向滑动的列表的 上3个和下3个及定时器
    var haudong = 0;
    var lunboimg = ['0px',
               '-825px',
               '-1650px'];
    $(".huadong-back").click(function(){
        if(haudong<0){
            haudong=lunboimg.length-1;
        }
        $(".BodyC-huadong").animate({
            left:lunboimg[haudong--]
        },1000)
    })
    $(".huadong-next").click(function(){
        if(haudong>lunboimg.length-1){
            haudong=0;
        }
        // $(".BodyC-huadong").css("left",lunboimg[haudong++])
        $(".BodyC-huadong").animate({
            left:lunboimg[haudong++]
        },1000)
    })
    setInterval(function(){
        if(haudong>lunboimg.length-1){
            haudong=0;
        }
        $(".BodyC-huadong").animate({
            left:lunboimg[haudong++]
        },1000)

    }, 10000);

    $(".BodyC-huadong-box").mouseover(function(){
        $(".huadong-back").show()
        $(".huadong-next").show()
    })
    $(".BodyC-huadong-box").mouseout(function(){
        $(".huadong-back").hide()
        $(".huadong-next").hide()
    })
})