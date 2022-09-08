window.onload=function () {

    var vue = new Vue({
        "el":"#user",
        data:{
            value1: '',
            value2: '',
            middle: '',
            uname:'',
            userList:{},
            userNum:'',
        },
        methods:{

        },

        watch:{

            userNum:function (userNum) {
                axios({
                    method:"post",
                    url:"admin.do",
                    params:{
                        operate:"getUser",
                        userNum:userNum + "",
                    }

                }).then(function (value) {

                    vue.userList = value.data;

                }).then(function (reason) {

                })
            },

            middle:function (middle) {
                // alert(vue.middle);
                axios({
                    method: "post",
                    url: "admin.do",
                    params: {
                        operate: "getUser",
                        userNum: vue.userNum + "",
                        middleArg:middle + ""

                    }
                }).then(function (value) {

                    vue.userList = value.data;

                }).catch(function (reason) {

                })

            },
            uname:function (uname) {
                axios({
                    method: "post",
                    url: "admin.do",
                    params: {
                        operate: "getUser",
                        uname:uname+""

                    }
                }).then(function (value) {

                    vue.userList = value.data;

                }).catch(function (reason) {

                })
            },

        },

        beforeMount:function () {

            this.userNum(vue.userNum);

        },

        mounted() {}
    });
}
