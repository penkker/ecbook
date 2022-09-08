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
                    url: "tea.do",
                    params: {
                        operate: "showGoodsInfo",
                    }
                }).then(function (value) {
                    var tea = value.data;
                    vue.id = tea.id;
                    vue.teaName = tea.teaName;
                    vue.teaPrice = tea.teaPrice;
                    vue.teaImgName = tea.teaImgName;
                    vue.teaIntro = tea.teaIntro;
                    vue.teaDetail = tea.teaDetail;
                    vue.type = tea.type;
                    vue.teaAddPrice = tea.teaAddPrice;

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