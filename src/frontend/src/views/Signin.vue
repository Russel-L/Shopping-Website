<template>
<div class="container">
    <div class="row">
        <div class="col-12 justify-content-center d-flex pt-5">
            <div id="signin" class="flex-item border">
                <h2 class="pt-4">Sign-In</h2>
                <form @submit="signin" class="pt-4 pl-4 pr-4">
                    <div class="form-group">
                        <label for="Email">Email</label>
                        <input type="email" v-model="email" class="form-control" required />
                    </div>
                    <div class="form-group">
                        <label for="Password">Password</label>
                        <input type="password" v-model="password" class="form-control" required />
                    </div>
                    <button class="btn btn-primary mt-2 py-0">Continue</button>
                </form>
            </div>
        </div>
    </div>
</div>
</template>


<script>
import axios from 'axios'
import swal from 'sweetalert'

export default {
    name: 'SignIn',
    props: ["baseURL"],
    data () {
        return {
            email: null,
            password: null
        }
    },
    methods: {
        signin(e) {
            e.preventDefault();
            const body = {
                email: this.email,
                password: this.password
            };
            const url = "api/signin"
            axios.post({url}, body)
            .then((res) => {
                this.$router.replace("/");
                localStorage.setItem("token", res.data.token);
                swal ({
                    text: "User signed in successfully",
                    icon: "success"
                });
                this.$emit("fetchData");
                this.$router.push({name: "home"});
            }).catch((err) => {
                swal({
                    text: "Unable to log you in",
                    icon: "error"
                });
                console.log(err);
            });
        }
    }
}
</script>


<style scoped>
@media screen {
    #signin-div {
        width: 40%;
    }
}
</style>