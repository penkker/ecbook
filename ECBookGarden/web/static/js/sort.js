window.onload=function () {
    var vue = new Vue({
        "el":"#sortCount",
        data:{
            sorts:{},
            teaList:{},

        },

        watch: {
            sorts:function () {
                axios({
                    method: "post",
                    url: "tea.do",
                    params: {
                        operate: "sortGoods",
                        sort:vue.sorts + "",
                    }
                }).then(function (value) {

                    vue.teaList = value.data;

                }).catch(function (reason) {

                })
            },

        },

    })
}
