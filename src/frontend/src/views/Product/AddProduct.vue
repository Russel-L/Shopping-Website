<template>
    <div class="container">
        <div class="row">
            <div class="col-12 text-center">
                <h4>Add Product</h4>
            </div>
        </div>
        <div class="row">
            <div class="col-3">

            </div>
            <div class="col-6">
                <form>
                    <div class="form-group">
                        <label>Name</label>
                        <input type="text" v-model="productName" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Description</label>
                        <input type="text" v-model="productDesc" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Price</label>
                        <input type="number" v-model="productPrice" class="form-control">
                    </div>
                    <!-- <div class="form-group">
                        <label>Image URL</label>
                        <input type="text" v-model="imageURL" class="form-control">
                    </div> -->
                    <button class="btn btn-primary" @click="addProduct()">Add Product</button>
                </form>
            </div>
            <div class="col-3">

            </div>
        </div>
    </div>
</template>


<script>
import axios from 'axios'
import swal from 'sweetalert'

export default {
    name: "AddProduct",
    component: {

    },
    props: ["baseURL"],
    data () {
        return {
            productDesc: null,
            productName: null,
            productPrice: null
            // imageURL: null
        }
    },
    methods: {
        addProduct() {
            const product = {
                productDesc: this.productDesc,
                productName: this.productName,
                productPrice: this.productPrice,
                // imageURL: this.imageURL
            }
            const url = "api/addProducts"
            axios.post(url, product)
            .then(() => {
                this.$emit("fetchData");
                this.$router.push({name: 'AdminProduct'});
                swal({
                    text: 'Product added',
                    icon: 'success'
                })
            }).catch((err) =>{
                swal({
                    text: 'Product was not added',
                    icon: 'error'
                })
                console.log("err", err);
            })
        }
    }
}
</script>


<style>

</style>