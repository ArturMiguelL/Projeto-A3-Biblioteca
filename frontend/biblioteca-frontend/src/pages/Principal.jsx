import NavBar from "../componentes/navbar/Navbar"
import { useState } from "react"
import "./Principal.css"


const mockEmprestimosAtivos = [
    { id: 1, usuario: "Artur", livro: "Clean Code", dataEmprestimo: "28/04/2026" },
    { id: 2, usuario: "Maria", livro: "O Programador Pragmático", dataEmprestimo: "29/04/2026" },
    { id: 3, usuario: "João", livro: "Interestelar (DVD)", dataEmprestimo: "30/04/2026" },
]

const mockUltimoLivro = {
    titulo: "Clean Code",
    autor: "Robert Martin",
    usuario: "Artur",
    data: "28/04/2026"
}

export default function Principal(){
    const [emprestimos] = useState(mockEmprestimosAtivos)
    const [ultimoLivro] = useState(mockUltimoLivro)

    return(
        <>
            <NavBar />
            <div className="principal-container">

                
                <section className="resumo">
                    <div className="card">
                        <span className="card-icon">📚</span>
                        <h3>Total de Livros</h3>
                        <p className="card-numero">24</p>
                    </div>
                    <div className="card">
                        <span className="card-icon">🔄</span>
                        <h3>Empréstimos Ativos</h3>
                        <p className="card-numero">{emprestimos.length}</p>
                    </div>
                    <div className="card">
                        <span className="card-icon">✅</span>
                        <h3>Disponíveis</h3>
                        <p className="card-numero">21</p>
                    </div>
                </section>

                
                <section className="secao">
                    <h2>Último Empréstimo</h2>
                    <div className="ultimo-livro">
                        <span className="livro-icon">📖</span>
                        <div>
                            <h3>{ultimoLivro.titulo}</h3>
                            <p>Autor: {ultimoLivro.autor}</p>
                            <p>Usuário: {ultimoLivro.usuario}</p>
                            <p>Data: {ultimoLivro.data}</p>
                        </div>
                    </div>
                </section>

        
                <section className="secao">
                    <h2>Empréstimos Ativos</h2>
                    <table className="tabela">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Usuário</th>
                                <th>Livro</th>
                                <th>Data</th>
                            </tr>
                        </thead>
                        <tbody>
                            {emprestimos.map((e) => (
                                <tr key={e.id}>
                                    <td>{e.id}</td>
                                    <td>{e.usuario}</td>
                                    <td>{e.livro}</td>
                                    <td>{e.dataEmprestimo}</td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                </section>

            </div>
        </>
    )
}