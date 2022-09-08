window.onload=function () {
    var vue = new Vue({
        "el":"#st",
        data:{
            left:{},
            right:{},

        },

        methods: {
            selectTea:function () {
                axios({
                    method: "post",
                    url: "tea.do",
                    params: {
                        operate: "selectTea",
                        left:left+"",
                        right:right+"",
                    }
                }).then(function (value) {

                }).catch(function (reason) {

                })
            },

        },

    })
}
