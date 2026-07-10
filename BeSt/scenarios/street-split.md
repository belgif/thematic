# Scenario: a streets is split into two, keeping name of one of the streets

## Before

Streetname
| ID   | Version | Name           | Status  | From       | Till |
| ---- | ------- | -------------- | ------- | ---------- | ---- |
| S456 | 3       | Rue du Marché  | current | 1984-01-01 | NULL |

Address
| ID   | Version | Status  | From       | Till   | Street | StreetV |
| ---- | ------- | ------- | -----------| ------ | ------ | ------- |
| A123 | 1       | current | 2024-02-01 | NULL   | S456   | 3       |
| A234 | 1       | current | 2026-01-01 | NULL   | S456   | 3       |

## After (INSPIRE)

Streetname
| ID   | Version | Name            | Status  | From       | Till       |
| ---- | ------- | --------------- | ------- | ---------- | ---------- |
| S456 | 3       | Rue du Marché   | current | 1984-01-01 | NULL       |
| S567 | 1       | Avenue Gertrude | current | 2026-07-01 | NULL       |

Address
| ID   | Version | Status  | From       | Till       | Street | StreetV |
| ---- | ------- | ------- | -----------| ---------- | ------ | ------- |
| A123 | 1       | current | 2024-02-01 | NULL       | S456   | 3       |
| A234 | 1       | current | 2026-01-01 | 2026-07-01 | S456   | 3       |
| A234 | 2       | current | 2026-07-01 | NULL       | S567   | 1       |

## After (Brussels)

Streetname
| ID   | Version | Name            | Status  | From       | Till       |
| ---- | ------- | --------------- | ------- | ---------- | ---------- |
| S456 | 3       | Rue du Marché   | current | 1984-01-01 | NULL       |
| S567 | 1       | Avenue Gertrude | current | 2026-07-01 | NULL       |

Address
| ID   | Version | Status  | From       | Till       | Street | StreetV |
| ---- | ------- | ------- | -----------| ---------- | ------ | ------- |
| A123 | 1       | current | 2024-02-01 | NULL       | S456   | 3       |
| A234 | 1       | current | 2026-01-01 | 2026-07-01 | S456   | 3       |
| A234 | 2       | current | 2026-07-01 | NULL       | S567   | 1       |

## After (Flanders)

Streetname
| ID   | Version | Name            | Status  | From       | Till       |
| ---- | ------- | --------------- | ------- | ---------- | ---------- |
| S456 | 3       | Rue du Marché   | current | 1984-01-01 | NULL       |
| S567 | 1       | Avenue Gertrude | current | 2026-07-01 | NULL       |

Address
| ID   | Version | Status  | From       | Till       | Street | StreetV |
| ---- | ------- | ------- | -----------| ---------- | ------ | ------- |
| A123 | 1       | current | 2024-02-01 | NULL       | S456   | 3       |
| A234 | 1       | current | 2026-01-01 | 2026-07-01 | S456   | 3       |
| A234 | 2       | retired | 2026-07-01 | NULL       | S456   | 3       |
| A456 | 1       | proposed| 2026-07-01 | 2026-07-01 | S567   | 1       |
| A456 | 2       | current | 2026-07-02 | NULL       | S567   | 1       |

Address ID Change

## After (Wallonie)

Streetname
| ID   | Version | Name            | Status  | From       | Till       |
| ---- | ------- | --------------- | ------- | ---------- | ---------- |
| S456 | 3       | Rue du Marché   | current | 1984-01-01 | NULL       |
| S567 | 1       | Avenue Gertrude | current | 2026-07-01 | NULL       |

Address
| ID   | Version | Status  | From       | Till       | Street | StreetV |
| ---- | ------- | ------- | -----------| ---------- | ------ | ------- |
| A123 | 1       | current | 2024-02-01 | NULL       | S456   | 3       |
| A234 | 1       | current | 2026-01-01 | 2026-07-01 | S456   | 3       |
| A234 | 2       | current | 2026-07-01 | NULL       | S567   | 1       |
