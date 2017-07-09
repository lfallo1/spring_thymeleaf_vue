<template>

		<div id="form-wrapper" class="row">
					<div class="col-sm-8 col-sm-offset-2">

							<h4 class="page-header">Checkout</h4>
							<form role="form" @submit.prevent="submit">
									<div class="form-group float-label-control" :class="hasError('firstName')">
											<label for="">First Name</label>
											<input v-model="form.firstName" type="text" class="form-control" placeholder="First name" />
									</div>
									<div class="form-group float-label-control" :class="hasError('lastName')">
											<label for="">Last Name</label>
											<input v-model="form.lastName" type="text" class="form-control" placeholder="Last name" />
									</div>
									<div class="form-group float-label-control" :class="hasError('addressLine1')">
											<label for="">Address</label>
											<input v-model="form.addressLine1" type="text" class="form-control" placeholder="Address" />
									</div>
									<div class="form-group float-label-control" :class="hasError('addressLine1')">
											<label for="">Address line 2 (optional)</label>
											<input v-model="form.addressLine2" type="text" class="form-control" placeholder="Address line 2" />
									</div>
									<div class="form-group float-label-control" :class="hasError('city')">
											<label for="">City</label>
											<input v-model="form.city" type="text" class="form-control" placeholder="city" />
									</div>
									<div class="form-group float-label-control" :class="hasError('stateCode')">
											<label for="">State</label>
											<input v-model="form.stateCode" type="text" class="form-control" placeholder="state" />
									</div>
									<div class="form-group float-label-control" :class="hasError('zipCode')">
											<label for="">Zipcode</label>
											<input v-model="form.zipCode" type="text" class="form-control" placeholder="zipcode" />
									</div>

									<button class="btn btn-md btn-primary" type="submit">Submit</button>
							</form>

							<app-formerrors v-if="errors.length > 0" :errors="errors"></app-formerrors>
					</div>
		</div>
</template>

<script>
import axios from 'axios';
import FormErrors from './FormErrors.vue';
import config from './config.js';

export default {
  data () {
    return {
      form: {
				firstName: '',
				lastName: '',
				addressLine1: '',
				addressLine2: '',
				city: '',
				stateCode: '',
				zipCode: ''
			},
			errors : []
    }
  },
	methods: {
		submit(){
			this.errors = [];

			axios.post('docheckout', this.form)
				.then(res => {
					debugger
					window.location.href = res.data.data;
				})
				.catch(err => {
					this.errors = err.response.data.data;
				});
		},
		hasError(field){
			return this.errors.filter(e=>e.field === field).length > 0 ? 'form-error' : '';
		}
	},
	components: {
		'app-formerrors' : FormErrors
	}
}
</script>

<style scoped>

.float-label-control { position: relative; margin-bottom: 1.5em; }
    .float-label-control ::-webkit-input-placeholder { color: transparent; }
    .float-label-control :-moz-placeholder { color: transparent; }
    .float-label-control ::-moz-placeholder { color: transparent; }
    .float-label-control :-ms-input-placeholder { color: transparent; }
    .float-label-control input:-webkit-autofill,
    .float-label-control textarea:-webkit-autofill { background-color: transparent !important; -webkit-box-shadow: 0 0 0 1000px white inset !important; -moz-box-shadow: 0 0 0 1000px white inset !important; box-shadow: 0 0 0 1000px white inset !important; }
    .float-label-control input, .float-label-control textarea, .float-label-control label { font-size: 1.3em; box-shadow: none; -webkit-box-shadow: none; }
        .float-label-control input:focus,
        .float-label-control textarea:focus { box-shadow: none; -webkit-box-shadow: none; border-bottom-width: 2px; padding-bottom: 0; }
        .float-label-control textarea:focus { padding-bottom: 4px; }
    .float-label-control input, .float-label-control textarea { display: block; width: 100%; padding: 0.1em 0em 1px 0em; border: none; border-radius: 0px; border-bottom: 1px solid #aaa; outline: none; margin: 0px; background: none; }
    .float-label-control textarea { padding: 0.1em 0em 5px 0em; }
    .float-label-control label { position: absolute; font-weight: normal; top: -1.0em; left: 0.08em; color: #aaaaaa; z-index: -1; font-size: 0.85em; -moz-animation: float-labels 300ms none ease-out; -webkit-animation: float-labels 300ms none ease-out; -o-animation: float-labels 300ms none ease-out; -ms-animation: float-labels 300ms none ease-out; -khtml-animation: float-labels 300ms none ease-out; animation: float-labels 300ms none ease-out; /* There is a bug sometimes pausing the animation. This avoids that.*/ animation-play-state: running !important; -webkit-animation-play-state: running !important; }
    .float-label-control input.empty + label,
    .float-label-control textarea.empty + label { top: 0.1em; font-size: 1.5em; animation: none; -webkit-animation: none; }
    .float-label-control input:not(.empty) + label,
    .float-label-control textarea:not(.empty) + label { z-index: 1; }
    .float-label-control input:not(.empty):focus + label,
    .float-label-control textarea:not(.empty):focus + label { color: #aaaaaa; }
    .float-label-control.label-bottom label { -moz-animation: float-labels-bottom 300ms none ease-out; -webkit-animation: float-labels-bottom 300ms none ease-out; -o-animation: float-labels-bottom 300ms none ease-out; -ms-animation: float-labels-bottom 300ms none ease-out; -khtml-animation: float-labels-bottom 300ms none ease-out; animation: float-labels-bottom 300ms none ease-out; }
    .float-label-control.label-bottom input:not(.empty) + label,
    .float-label-control.label-bottom textarea:not(.empty) + label { top: 3em; }


@keyframes float-labels {
    0% { opacity: 1; color: #aaa; top: 0.1em; font-size: 1.5em; }
    20% { font-size: 1.5em; opacity: 0; }
    30% { top: 0.1em; }
    50% { opacity: 0; font-size: 0.85em; }
    100% { top: -1em; opacity: 1; }
}

@-webkit-keyframes float-labels {
    0% { opacity: 1; color: #aaa; top: 0.1em; font-size: 1.5em; }
    20% { font-size: 1.5em; opacity: 0; }
    30% { top: 0.1em; }
    50% { opacity: 0; font-size: 0.85em; }
    100% { top: -1em; opacity: 1; }
}

@keyframes float-labels-bottom {
    0% { opacity: 1; color: #aaa; top: 0.1em; font-size: 1.5em; }
    20% { font-size: 1.5em; opacity: 0; }
    30% { top: 0.1em; }
    50% { opacity: 0; font-size: 0.85em; }
    100% { top: 3em; opacity: 1; }
}

@-webkit-keyframes float-labels-bottom {
    0% { opacity: 1; color: #aaa; top: 0.1em; font-size: 1.5em; }
    20% { font-size: 1.5em; opacity: 0; }
    30% { top: 0.1em; }
    50% { opacity: 0; font-size: 0.85em; }
    100% { top: 3em; opacity: 1; }
}

#form-wrapper{
    margin-bottom: 75px;
}
</style>
