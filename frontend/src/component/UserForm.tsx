import React, { Component } from 'react';

interface States {
    firstName: string;
    lastName: string;
    email: string;
    password: string;
}

interface Props {

}

export class UserForm extends Component<Props, States> {
    constructor(props: Props) {
        super(props);
        this.state = {
            firstName: '',
            lastName: '',
            email: '',
            password: '',
        };
    }

    handleSubmit = () => {
        console.log(this.state)
    };

    handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const { name, value } = e.target;
        this.setState({ [name]: value } as Pick<States, keyof States>);
    };

    render() {
        const { firstName, lastName, email, password } = this.state;
        return (
            <form>
                <label>
                    First Name:
                    <input
                        type="text"
                        name="firstName"
                        value={firstName}
                        onChange={this.handleChange}
                    />
                </label>
                <br />
                <label>
                    Last Name:
                    <input
                        type="text"
                        name="lastName"
                        value={lastName}
                        onChange={this.handleChange}
                    />
                </label>
                <br />
                <label>
                    Email:
                    <input
                        type="email"
                        name="email"
                        value={email}
                        onChange={this.handleChange}
                    />
                </label>
                <br />
                <label>
                    Password:
                    <input
                        type="password"
                        name="password"
                        value={password}
                        onChange={this.handleChange}
                    />
                </label>
                <br />
                <button type="button"
                        onClick={this.handleSubmit}
                >Submit</button>
            </form>
        );
    }
}
