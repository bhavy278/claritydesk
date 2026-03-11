# 🧠 ClarityDesk

> AI-powered intelligence layer for emails & documents

ClarityDesk connects to your Gmail and document vault,
extracts deadlines, risks, and obligations using GPT-4o,
and surfaces them in a unified action center — so nothing
slips through the cracks.

## ✨ Features
- 📬 Gmail integration — AI reads, labels & analyzes emails
- 📄 Document analysis — extracts risks, deadlines, fines from PDF/DOCX
- 🔗 Conflict detection — flags contradictions across emails & docs
- 📅 Smart timeline — unified deadline view across all sources
- 💬 RAG chat — ask questions across your entire workspace
- 🔔 Proactive alerts — AI notifies you before deadlines are missed

## 🏗️ Tech Stack
| Layer | Technology |
|-------|------------|
| Frontend | Next.js 14 (App Router) |
| Backend | Spring Boot 3 (Java 21) |
| Database | PostgreSQL + pgvector |
| Cache | Redis |
| AI | OpenAI GPT-4o + Embeddings |
| Email | Gmail API |
| Auth | Google OAuth2 + JWT |
| DevOps | Docker + GitHub Actions + AWS EC2 |

## 🚀 Quick Start
\`\`\`bash
git clone https://github.com/bhavy278/claritydesk.git
cd claritydesk
cp .env.example .env
# Fill in your API keys in .env
docker-compose -f docker/docker-compose.yml up -d
\`\`\`

## 📁 Project Structure
\`\`\`
claritydesk/
├── frontend/          # Next.js 14 app
├── backend/           # Spring Boot 3 app
├── docker/            # Docker Compose configs
├── docs/              # Architecture & API docs
└── scripts/           # Dev utility scripts
\`\`\`

## 📖 Documentation
- [Architecture](docs/architecture.md)
- [API Spec](docs/api-spec.md)
- [Contributing](CONTRIBUTING.md)

## 📄 License
MIT
EOF