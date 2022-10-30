<template>
    <div class="container">
        <div class="row">
            <div class="col-12 text-center">
                <h4 class="pt-3">Edit Product</h4>
            </div>
        </div>
        <div class="row">
            <div class="col-3"></div>
            <div class="col-6">
                <form v-if="product">
                    <div class="form-group">
                        <label>Name</label>
                        <input type="text" v-model="product.name" class="form-control" required />
                    </div>
                    <div class="form-group">
                        <label>Description</label>
                        <input type="text" v-model="product.description" class="form-control" required />
                    </div>
                    <div class="form-group">
                        <label>Price</label>
                        <input type="number" v-model="product.price" class="form-control" required />
                    </div>
                    <!-- <div class="form-group">
                        <label>Image URL</label>
                        <input type="text" v-model="product.imageURL" class="form-control" required />
                    </div> -->
                    <button class="btn btn-primary" @click="editProduct()">Add Product</button>
                </form>
            </div>
            <div class="col-3"></div>
        </div>
    </div>
</template>


<script>
import axios from 'axios'
import swal from 'sweetalert'

export default {
    name: 'EditProduct',
    components: {

    },
    data () {
        return {
            product: null,
            id: null
        }
    },
    props: ["baseURL", "products"],
    methods: {
        async editProduct () {
            const url = "api/updateProducts"
            await axios.post(`${url}/${this.id}`, this.product)
            .then(() => {
                this.$emit("fetchData");
                this.$router.push({name: 'AdminProduct'})
                swal({
                    text: 'Product has been updated successfully',
                    icon: 'success'
                })
            }).catch(err => console.log('err', err));
        }
    },
    mounted() {
        this.id = this.$route.params.id
        this.product = this.products.find(product => product.id == this.id)
    }
}
</script>


<style>

</style>