window.onload=function () {

    var vue = new Vue({
        "el":"#admin",
        data:{
            value1: '',
            value2: '',
            adminList:{},
            middle: '',
        },
        methods:{

        },

        watch:{

            middle:function (middle) {
                //测试发送过来的时间格式
                // alert(middle);
                axios({
                    method: "post",
                    url: "admin.do",
                    params: {
                        operate: "getAdmin",
                        middleArg:middle + ""
                    }
                }).then(function (value) {

                    vue.adminList = value.data;

                }).catch(function (reason) {

                })

            },

        },

        beforeMount:function () {

            this.middle(vue.middle);

        },

        mounted() {}
    });

}
