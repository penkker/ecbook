window.onload=function () {
    var vue = new Vue({
        "el":"#getTea",
        data:{
            teaList:{},

        },

        methods: {
            getTeaList:function () {
                axios({
                    method: "post",
                    url: "tea.do",
                    params: {
                        operate: "getTeaListAdvan",
                    }
                }).then(function (value) {

                    vue.teaList = value.data;

                }).catch(function (reason) {

                })
            },

        },
        mounted: function () {

            this.getTeaList();

        },

    })
}