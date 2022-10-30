<template>
<div class="container">
    <div class="row pt-5">
        <div class="col-md-1">

        </div>
        <!-- <div class="col-md-4 col-12">
            <img :src="product.imageURL" class="img-fluid" />
        </div> -->
        <div class="col-md-6 col-12 pt-3 pt-md-0">
            <h4>{{ product.name }}</h4>
            <h6>{{ product.price }}</h6>
            <p>
                {{ product.description }}
            </p>
            <div class="d-flex flex-row justify-content-between">
                <div class="input-group col-md-3 col-4 p-0">
                    <div class="input-group-prepend">
                        <span class="input-group-text">Quantity</span>
                    </div>
                    <input type="number" v-model="quantity" class="form-control" />
                </div>
                <div class="input-group col-md-3 col-4 p-0">
                    <button class="btn" @click="addToCart(this.id)">
                        Add to Cart
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>
</template>

<script>
import axios from 'axios';
import swal from 'sweetalert'

export default {
    name: 'ShowDetails',
    data() {
        return {
            product: {},
            quantity: 1
        }
    },
    props: ["baseURL", "products"],
    methods: {
        addToCart() {
            if (!this.token) {
                swal({
                    text: "Please login to add item to cart",
                    icon: "error"
                });
                return;
            }
            const url = "/api/addCart"
            axios.post(`${url}/?token=${this.token}`, {
                productId: this.id,
                quantity: this.quantity
            }).then((res) => {
                if (res.status == 201) {
                    swal({
                        text: "Product added in cart",
                        icon: "success"
                    })
                }
            }).catch(err => console.log("err", err));
        }
    },
    mounted() {
        this.id = this.$route.params.id
        this.product = this.products.find(product => product.id == this.id)
        this.token = localStorage.getItem("token")
    }
}
</script>