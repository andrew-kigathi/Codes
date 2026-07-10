import { useForm } from "react-hook-form";

export function Signup() {
    const {
        register,
        handleSubmit,
        formState: { errors },
        } = useForm({
        mode: "onBlur",
    });

    const onSubmit = (data) => {
        console.log(data);
    };

    return (
    <>
        <h1>Signup Form</h1>
        <form onSubmit={handleSubmit(onSubmit)} className="signup-form">
            <div className="mb-3">
                <label htmlFor="fullname" className="form-label">
                    Full Name
                </label>

                <input
                    type="text"
                    className="form-control"
                    id="fullname"
                    name="fullname"
                    placeholder="Enter your full name"
                    {...register("fullname", {
                        required: "Full Name is Required",
                    })}
                />

                {errors.fullname && (
                <span className="invalid-feedback">
                    {errors.fullname.message}
                </span>
                )}
            </div>

            <button type="submit" className="btn btn-primary">
                Sign Up
            </button>
        </form>
    </>
    );
}