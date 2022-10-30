<template>
<div class="container">
    <div class="row">
        <div class="col-12 text-center">
            <h3 class="pt-3">
                Shopping Cart
            </h3>
        </div>
    </div>
        <div v-for="cartItem in cartItems" :key="cartItem.id" class="row mt-2 pt-3">
            <div class="col-2"></div>
            <!-- <div class="col-md-3">
                <img :src="cartItem.product.imageURL" alt="" class="w-100 card-image-top embed-responsive-item" style="object-fit: cover">
            </div> -->
            <div class="col-md-5 px-3">
                <div class="card-block px-3">
                    <h6 class="card-title">
                        {{ cartItem.product.name }}
                    </h6>
                    <p class="mb-0" id="item-price">
                        $ {{ cartItem.product.price }}
                    </p>
                    <p class="mb-0">Quantity: {{cartItem.quantity}}</p>
                    <p class="mb-0">
                        Total: <span class="font-weight-bold">
                            $ {{ cartItem.product.price * cartItem.quantity}}
                        </span>
                    </p>
                    <a href="#" class="text-right" @click="deleteItem(cartItem.id)">Remove from Cart</a>
                </div>
            </div>
        </div>
    <div class="total-cost pt-2 text-right">
        <h4>Total: ${{ totalCost.toFixed(2) }}</h4>
    </div>
    <div class="pt-2 text-right">
        <button class="btn btn-primary" @click="cashOut()">Check-out</button>
    </div>
</div>
</template>


<script>
import axios from 'axios'
import swal from 'sweetalert'

export default {
    name: 'CartView',
    data () {
        return {
            cartItems: [],
            token: null,
            totalCost: 0
        }
    },
    props: ["baseURL"],
    methods : {
        listCartItems() {
            const url = "/api/cart";
            axios.get(`${url}/?=token=${this.token}`)
            .then(res => {
                const result = res.data;
                this.cartItems = result.cartItems;
                this.totalCost = result.totalCost;
            }).catch((err) => console.log("err", err))
        },
        deleteItem(itemId) {
            const url = "/api/deleteCart"
            axios.delete(`${url}/${itemId}/?token=${this.token}`)
            .then((res) => {
                if(res.status == 200) {
                    this.$router.go(0);
                }
            }).catch((err => console.log("err", err)))
        },
        cashOut() {
            this.cartItems.forEach(cartItem => {
                this.deleteItem(cartItem.id)
            });
            swal ({
                    text: "Successfully cashed out. Thanks for shopping!",
                    icon: "success"
            });
        }
    },
    mounted() {
        this.token = localStorage.getItem("token");
        this.listCartItems();
    }
}
</script>


<style>

</style>