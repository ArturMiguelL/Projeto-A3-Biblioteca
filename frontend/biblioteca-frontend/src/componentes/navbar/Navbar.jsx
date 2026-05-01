import { useNavigate, Link } from "react-router-dom";
import "./Navbar.css"

export default function NavBar(){

    const navigate = useNavigate()

 function handleLogout(){
    localStorage.removeItem("token")
    navigate("/")
 }

 return(

    <header >
        <nav>
            <h1>Biblioteca Anhembi</h1>  
            <div>
            <Link to="/">Home</Link>
            <Link to="/"></Link>
            <Link to="/"></Link>
            <Link to="/"></Link>
            <Link to="/" onClick={handleLogout}>sair</Link>
            </div>
        </nav>
    </header>
 )
}