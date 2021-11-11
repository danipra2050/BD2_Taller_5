import React from 'react';
import { Fade, Slide } from "react-reveal";

function Login(){
    const [mail, setMail] = React.useState();

    const handleChange = (e) => {
        const { name, value } = e.target;
        setMail({...mail, [name]: value});
    }

    function singin(event){
        event.preventDefault();
        var url = "http://localhost:7001/taller5-1.0-SNAPSHOT/pet/api/login";
        fetch(url,{
            method: "POST",
            body: mail,
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(res => res.json())
            .catch(error => console.log('Error: ', error))
            .then(response => console.log(response));
    }
    return(
        <section id="contact"><br/><br/>
            <Fade bottom duration={1000}>
                <div className="row section-head">
                    <h1><span>Sign In</span></h1>
                </div>
            </Fade>
            <div className="row">
                <Slide left duration={1000}>
                    <div className="eight columns">
                        <form>
                            <fieldset>
                                <div>
                                    <label htmlFor="email">Correo<span className="required">*</span></label>
                                    <input type="text" id="mail" name="mail" onChange={handleChange}/>
                                </div>
                                <div>
                                    <button className="submit" onClick={(e) => singin(e)}>Ingresar</button>
                                </div>
                            </fieldset>
                        </form>
                    </div>
                </Slide>
            </div>
        </section>
    );
}
export default Login;