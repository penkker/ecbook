window.onload=function () {
    var vue = new Vue({
        "el":"#showGoodsInfos",
        data:{
            goodsList:'',
            id:"",
            teaName:"",
            teaPrice:"",
            teaImgName:"bgmj",
            teaIntro:"",
            teaDetail:"",
            type:"",
            teaAddPrice:""

        },

        methods: {
            showGoodsInfo:function () {
                axios({
                    method: "post",
                    url: "book.do",
                    params: {
                        operate: "showGoodsInfo",
                    }
                }).then(function (value) {
                    var hotBook = value.data;
                    vue.id = hotBook.id;
                    vue.teaName = hotBook.bookName;
                    vue.teaPrice = hotBook.price;
                    vue.teaImgName = hotBook.bookImg;
                    vue.teaIntro = hotBook.authorIntro;
                    vue.teaDetail = hotBook.bookIntro;
                    vue.type = hotBook.type;
                    vue.teaAddPrice = hotBook.record;

                }).catch(function (reason) {

                })
            },

        },


        // 4.数据挂载之前
        beforeMount:function(){
            this.showGoodsInfo();
        },


    })
}