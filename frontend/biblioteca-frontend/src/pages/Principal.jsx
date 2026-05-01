import NavBar from "../componentes/navbar/Navbar"
import { useState, useEffect } from "react"
import { useNavigate } from "react-router-dom"

export default function Principal(){
    return(
        <>
            <NavBar />
            <div style={{ padding: "80px 40px 40px 40px" }}>
                <h1>Página principal onde vai ficar as informações dos livros</h1>
            </div>
        </>
    )
}
