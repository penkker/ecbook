window.onload=function () {

    var vue = new Vue({
        "el":"#book",
        data:{
            value1: '',
            value2: '',
            bookList:{},
            middle: '',
            bookNum:'',
            bookName:'',
        },
        methods:{

        },

        watch:{

            bookNum:function (bookNum) {
                axios({
                    method:"post",
                    url:"admin.do",
                    params:{
                        operate:"getBook",
                        bookNum:bookNum + "",
                    }

                }).then(function (value) {

                    vue.bookList = value.data;

                }).then(function (reason) {

                })
            },

            middle:function (middle) {
                // alert(vue.middle);
                axios({
                    method: "post",
                    url: "admin.do",
                    params: {
                        operate: "getBook",
                        bookNum: vue.bookNum + "",
                        middleArg:middle + ""

                    }
                }).then(function (value) {

                    vue.bookList = value.data;

                }).catch(function (reason) {

                })

            },
            bookName:function (bookName) {
                axios({
                    method: "post",
                    url: "admin.do",
                    params: {
                        operate: "getBook",
                        bookName:bookName+""

                    }
                }).then(function (value) {

                    vue.bookList = value.data;

                }).catch(function (reason) {

                })
            },

        },

        beforeMount:function () {

            this.bookNum(vue.bookNum);

        },

        mounted() {}
    });
}
