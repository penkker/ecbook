window.onload=function () {
    var vue = new Vue({
        "el":"#rep",
        data:{
            replyList:{},
            remark:'',
        },

        methods: {
            getRemark: function () {
                axios({
                    method: "post",
                    url: "reply.do",
                    params: {
                        operate: "setReply",
                        remark: vue.remark + "",
                    }
                }).then(function (value) {

                    vue.replyList = value.data;

                }).catch(function (reason) {

                })

            },
            getReplyList:function () {
                axios({
                    method: "post",
                    url: "reply.do",
                    params: {
                        operate: "getReplyList",
                    }
                }).then(function (value) {

                    vue.replyList = value.data;
                    alert(vue.replyList);

                }).catch(function (reason) {

                })
            },

            acquire:function () {
                axios({
                    method: "post",
                    url: "reply.do",
                    params: {
                        operate: "getReplyList",
                    }
                }).then(function (value) {

                    vue.replyList = value.data;
                    alert(vue.replyList);

                }).catch(function (reason) {

                })
            }

        },
        beforeMount: function () {

            this.getReplyList();

        },

    })
}