$(document).ready(function () {
    $("#userForm").validate({
        rules: {
            firstName: {
                required: true,
                lettersonly: true
            },
            lastName: {
                required: true,
                lettersonly: true
            },
            phoneNumber: {
                required: true,
                digits: true,
                minlength: 10,
                maxlength: 12
            },
            email: {
                required: true,
                email: true
            },
            address: {
                required: true
            }
        },
        messages: {
            firstName: {
                required: "First name is required",
                lettersonly: "Only letters are allowed"
            },
            lastName: {
                required: "Last name is required",
                lettersonly: "Only letters are allowed"
            },
            phoneNumber: {
                required: "Phone number is required",
                digits: "Only digits are allowed",
                minlength: "Phone number must be at least 10 digits",
                maxlength: "Phone number must not exceed 12 digits"
            },
            email: {
                required: "Email is required",
                email: "Enter a valid email address"
            },
            address: {
                required: "Address is required"
            }
        }
    });

     // Validate the edit user form
     $("#editUser").validate({
        rules: {
            firstName: {
                required: true,
                lettersonly: true
            },
            lastName: {
                required: true,
                lettersonly: true
            },
            phoneNumber: {
                required: true,
                digits: true, // Use digits instead of numericOnly for jQuery Validation
                minlength: 10,
                maxlength: 12
            },
            email: {
                required: true,
                email: true
            },
            address: {
                required: true
            }
        },
        messages: {
            firstName: {
                required: "First name is required",
                lettersonly: "Only letters are allowed"
            },
            lastName: {
                required: "Last name is required",
                lettersonly: "Only letters are allowed"
            },
            phoneNumber: {
                required: "Phone number is required",
                digits: "Please enter a valid phone number",
                minlength: "Phone number must be at least 10 digits long",
                maxlength: "Phone number must not exceed 12 digits"
            },
            email: {
                required: "Email is required",
                email: "Please enter a valid email address"
            },
            address: {
                required: "Address is required"
            }
        }
    });


    // Custom validation method for letters only
    $.validator.addMethod("lettersonly", function(value, element) {
        return this.optional(element) || /^[a-zA-Z\s]+$/.test(value);
    }, "Letters only please");
});
