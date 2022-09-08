window.onload = function () {
    var vue = new Vue({
        el:"#cont",
        data:{
            vueCartItemList:{},
            cartItemNum:{},
            totalMoney:{},
        },
        methods:{
            //展示购物车
            getCart:function () {
                axios({
                    method:"post",
                    url:"cart.do",
                    params:{
                        operate:"showCartItemList"
                    }

                }).then(function (value) {

                    vue.getCartItemNum();
                    vue.vueCartItemList = value.data;

                }).catch(function (reason) {

                })
            },
            //加减号改变购物车中框显示数量
            addBuyCount:function (id,buyCount){
                axios({
                    method:"post",
                    url:"cart.do",
                    params:{
                        operate: "addCount",
                        cartItemId:id+"",
                        buyCount:buyCount+""
                    }

                }).then(function (value) {

                    vue.getCartItemNum();
                    vue.vueCartItemList = value.data;

                }).catch(function () {

                })
            },
            //商品的件数
            getCartItemNum:function () {
                axios({
                    method:"post",
                    url:"cart.do",
                    params:{
                        operate: "getCartItemNums",
                    }

                }).then(function (value) {

                    vue.getToalMoney();
                    vue.cartItemNum = value.data;

                }).catch(function () {

                })
            },
            //商品合计价格
            getToalMoney:function () {
                axios({
                    method:"post",
                    url:"cart.do",
                    params:{
                        operate:"getTotalPrice"
                    }

                }).then(function (value) {

                    vue.totalMoney  = value.data;

                }).catch(function (reason) {

                });
            },

            //删除一条购物车项信息
            delCartItem:function (id) {
                axios({
                    method:"post",
                    url:"cart.do",
                    params:{
                        operate:"delCartItem",
                        id:id+"",
                    }

                }).then(function (value) {

                    alert("删除成功!");
                    //刷新购物车
                    vue.getCart();

                }).catch(function (reason) {

                });
            },
            //清空购物车
            cleanCart:function () {
                axios({
                    method:"post",
                    url:"cart.do",
                    params:{
                        operate:"cleanCart",
                    }

                }).then(function (value) {

                    alert("购物车已清空!");
                    vue.getCart();

                }).catch(function (reason) {

                });
            },

        },
        // 数据加载之前
        beforeMount:function(){
            this.getCart();
            // //绑定加减框中的值
            // this.addBuyCount();
        },

    });
}