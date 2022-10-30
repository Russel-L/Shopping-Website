<template>
    <div class="container">
        <div class="row">
            <div class="col-12 text-center pt-3">
                <div id="signup-div" class="flex-item-border">
                    <h2 class="pt-4 pl-4">Create Account</h2>
                    <form class="pt-4 pl-4 pr-4">
                        <div class="form-group">
                            <label for="Email">Email</label>
                            <input type="email" v-model="email" class="form-control" required />
                        </div>
                        <div class="form-row">
                            <div class="col">
                                <div class="form-group">
                                    <label>First Name</label>
                                    <input type="text" v-model="firstName" class="form-control" required />
                                </div>
                            </div>
                            <div class="col">
                                <div class="form-group">
                                    <label for="LastName">Last Name</label>
                                    <input type="text" v-model="lastName" class="form-control" required />
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="Password">Password</label>
                            <input type="password" v-model="password" class="form-control" required />
                        </div>
                        <div class="form-group">
                            <label for="Password">Confirm Password</label>
                            <input type="password" v-model="passwordConfirm" class="form-control" required />
                        </div>
                        <button type="button" class="btn btn-primary mt-2 py-0" @click="signUp()">Create Account</button>
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
  name: "SignUp",
  props: ["baseURL"],
  data() {
    return {
      email: null,
      firstName: null,
      lastName: null,
      password: null,
      passwordConfirm: null,
    };
  },
  methods: {
    signUp () {
      const url = "/api/signup";
      // if the password matches
      if (this.password === this.passwordConfirm) {
        // make the post body
        const user = {
          email: this.email,
          firstName: this.firstName,
          lastName: this.lastName,
          password: this.password,
        };

        // call the API
        axios
          .post(url, user)
          .then(() => {
            // redirect to home page
            this.$router.replace("/");
            swal({
              text: "User signup successful. Please Login",
              icon: "success",
              closeOnClickOutside: false,
            });
          })
          .catch((err) => {
            console.log(err);
          });
      } else {
        // passwords are not matching
        swal({
          text: "Error! Passwords are not matching",
          icon: "error",
          closeOnClickOutside: false,
        });
      }
    },
  },
};
</script>