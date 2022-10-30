import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import AdminView from '../views/AdminView.vue'
import ProductView from '../views/Product/Product.vue'
import AddProduct from '../views/Product/AddProduct.vue'
import EditProduct from '../views/Product/EditProduct.vue'
import ShowDetails from '../views/Product/ShowDetails.vue'
import SignUp from '../views/Signup.vue'
import SignIn from '../views/Signin.vue'
import CartView from '../views/Cart.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path: '/admin',
    name: 'admin',
    component: AdminView
  },
  {
    path: '/admin/product',
    name: 'AdminProduct',
    component: ProductView
  },
  {
    path: '/admin/product/new',
    name: 'AddProduct',
    component: AddProduct
  },
  {
    path: '/admin/product/edit',
    name: 'EditProduct',
    component: EditProduct
  },
  {
    path: '/product/show/:id',
    name: 'ShowDetails',
    component: ShowDetails
  },
  {
    path: '/signup',
    name: 'SignUp',
    component: SignUp
  },
  {
    path: '/signin',
    name: 'SignIn',
    component: SignIn
  },
  {
    path: '/cart',
    name: 'cart',
    component: CartView
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
