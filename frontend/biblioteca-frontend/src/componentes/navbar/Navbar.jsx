import { useNavigate, Link } from "react-router-dom";
import "./Navbar.css"

export default function NavBar(){
    return(
        <header>
            <nav>
                <h1>📚 Biblioteca Anhembi</h1>
                <div className="nav-links">
                    <a href="#">Home</a>
                    <a href="#">Acervo</a>
                    <a href="#">Usuários</a>
                    <a href="#">Empréstimos</a>
                </div>
            </nav>
        </header>
    )
}